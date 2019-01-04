#include <jni.h>
#include <opencv2/opencv.hpp>
#include <android/log.h>

using namespace cv;
using namespace std;

//#include <string>
//
//extern "C" JNIEXPORT jstring
//
//JNICALL
//Java_com_tistory_webnautes_useopencvwithcmake_MainActivity_stringFromJNI(
//        JNIEnv *env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

float resize(Mat img_src, Mat &img_resize, int resize_width){

    float scale = resize_width / (float)img_src.cols ;
    if (img_src.cols > resize_width) {
        int new_height = cvRound(img_src.rows * scale);
        resize(img_src, img_resize, Size(resize_width, new_height));
    }
    else {
        img_resize = img_src;
    }
    return scale;
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_user_myapplication_MainActivity_ConvertRGBtoGray   (JNIEnv *env,
                                                                     jobject instance,
                                                                     jlong matAddrInput,
                                                                     jlong matAddrResult) {
    // 입력 RGBA 이미지를 GRAY 이미지로 변환
    Mat &matInput = *(Mat *)matAddrInput;
    Mat &matResult = *(Mat *)matAddrResult;
    cvtColor(matInput, matResult, COLOR_RGBA2GRAY);

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_user_myapplication_MainActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO


    //return env->NewStringUTF(returnValue);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_user_openCV_MainActivity_loadCascade(JNIEnv *env, jobject instance,
                                                      jstring cascadeFileName_) {
    //const char *cascadeFileName = env->GetStringUTFChars(cascadeFileName_, 0);

    // TODO
    const char *nativeFileNameString = env->GetStringUTFChars(cascadeFileName_, 0);

    string baseDir("/storage/emulated/0/");
    baseDir.append(nativeFileNameString);
    const char *pathDir = baseDir.c_str();


    jlong ret = 0;
    ret = (jlong) new CascadeClassifier(pathDir);
    if (((CascadeClassifier *) ret)->empty()) {
        __android_log_print(ANDROID_LOG_DEBUG, "native-lib :: ",
                            "CascadeClassifier로 로딩 실패  %s", nativeFileNameString);
    }
    else
        __android_log_print(ANDROID_LOG_DEBUG, "native-lib :: ",
                            "CascadeClassifier로 로딩 성공 %s", nativeFileNameString);
    env->ReleaseStringUTFChars(cascadeFileName_, nativeFileNameString);

    return ret;

    //env->ReleaseStringUTFChars(cascadeFileName_, cascadeFileName);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_user_openCV_MainActivity_detect(JNIEnv *env, jobject instance,
                                                 jlong cascadeClassifier_face,
                                                 jlong cascadeClassifier_eye,
                                                 jlong cascadeClassifier_nose, jlong matAddrInput,
                                                 jlong matAddrResult) {


    Mat &img_input = *(Mat *) matAddrInput;
    Mat &img_result = *(Mat *) matAddrResult;

    img_result = img_input.clone();

    std::vector<Rect> faces;
    Mat img_gray;

    cvtColor(img_input, img_gray, COLOR_BGR2GRAY);
    equalizeHist(img_gray, img_gray);

    Mat img_resize;
    float resizeRatio = resize(img_gray, img_resize, 640);

    //-- Detect faces
    ((CascadeClassifier *) cascadeClassifier_face)->detectMultiScale(img_resize, faces, 1.1, 2,
                                                                     0 | CASCADE_SCALE_IMAGE,
                                                                     Size(30, 30));


    __android_log_print(ANDROID_LOG_DEBUG, (char *) "native-lib :: ",
                        (char *) "face %d found ", faces.size());


    for (int i = 0; i < (int)faces.size(); i++) {
        double real_facesize_x = faces[i].x / resizeRatio;
        double real_facesize_y = faces[i].y / resizeRatio;
        double real_facesize_width = faces[i].width / resizeRatio;
        double real_facesize_height = faces[i].height / resizeRatio;
        Point center(real_facesize_x + real_facesize_width / 2,
                     real_facesize_y + real_facesize_height / 2);;
        Rect face_area(real_facesize_x, real_facesize_y, real_facesize_width, real_facesize_height);
        //rectangle(img_result,face_area,Scalar(0,255,0),2);
        Mat faceROI = img_gray(face_area);
        std::vector<Rect> eyes;
        std::vector<Rect> nose;

        //-- In each face, detect eyes
        ((CascadeClassifier *) cascadeClassifier_eye)->detectMultiScale(faceROI, eyes, 1.1, 2,
                                                                        0 | CASCADE_SCALE_IMAGE,
                                                                        Size(30, 30));

        //nose
        ((CascadeClassifier *) cascadeClassifier_nose)->detectMultiScale(faceROI, nose, 1.1, 2,
                                                                        0 | CASCADE_SCALE_IMAGE,
                                                                        Size(30, 30));


        for (size_t j = 0; j < eyes.size(); j++) {
            Point eye_center( real_facesize_x + eyes[j].x + eyes[j].width/2, real_facesize_y + eyes[j].y + eyes[j].height/2 );
            int radius = cvRound( (eyes[j].width + eyes[j].height)*0.25 );
            //circle( img_result, eye_center, radius, Scalar( 89, 89, 89 ), 4, 8, 0 );
        }

        for (size_t j = 0; j < nose.size(); j++) {
            double real_nosesize_x = real_facesize_x+nose[j].x;
            double real_nosesize_y = real_facesize_y+nose[j].y;
            double real_nosesize_width = nose[j].width;
            double real_nosesize_height = nose[j].height;
            Rect nose_area(real_nosesize_x, real_nosesize_y, real_nosesize_width, real_nosesize_height);
            //rectangle(img_result,nose_area,Scalar(255,0,0),2);

            double real_forehead_x =  real_facesize_x;
            double real_forehead_y = real_facesize_y;
            double real_forehead_width = real_facesize_width;
            double real_forehead_height = real_facesize_height-nose[j].height-nose[j].height-nose[j].height;
            Rect forehead_area(real_forehead_x, real_forehead_y, real_forehead_width, real_forehead_height);
            rectangle(img_result,forehead_area,Scalar(0,0,255),2);

            double real_cheekl_x =  real_facesize_x;
            double real_cheekl_y = real_facesize_y+nose[j].height*2;
            double real_cheekl_width = (real_facesize_width/2)-(nose[j].width/2);
            double real_cheekl_height = real_facesize_height-real_forehead_height-nose[j].height;
            Rect cheekleft_area(real_cheekl_x, real_cheekl_y, real_cheekl_width, real_cheekl_height);
            rectangle(img_result,cheekleft_area,Scalar(0,0,0),2);

            double real_cheekr_x =  real_facesize_x+nose[j].x+nose[j].width;
            double real_cheekr_y = real_facesize_y+nose[j].height*2;
            double real_cheekr_width = (real_facesize_width/2)-(nose[j].width/2);
            double real_cheekr_height = real_facesize_height-real_forehead_height-nose[j].height;
            Rect cheekright_area(real_cheekr_x, real_cheekr_y, real_cheekr_width, real_cheekr_height);
            rectangle(img_result,cheekright_area,Scalar(255,128,0),2);
        }
    }
}