package com.cps.interfaces;


import com.cps.models.requests.*;
import com.cps.models.responses.JsonResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static com.cps.helpers.Constant.*;


/**
 * Created by Tranxit Technologies Pvt Ltd, Chennai
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST(SERVER_EVENT_NEWS)
    Call<JsonResponse> event_news(@Field("type") int type);

    @POST(SERVER_CONTACTUS)
    Call<JsonResponse> contactus(@Body SendContact sendContact);

    @POST(SERVER_ADMISSION_DATA)
    Call<JsonResponse> admission_data(@Body SendAdmission admission);

    @POST(SERVER_ADMISSION_MEDIA)
    Call<JsonResponse> admission_media(@Body SendAdmissionMedia admission);

    @POST(SERVER_GALLERY)
    Call<JsonResponse> gallery();

    @POST(SERVER_NOTIFICATION_BEFORE)
    Call<JsonResponse> notification_before();



    @POST(SERVER_LOGIN)
    Call<JsonResponse> login(@Body SendLogin sendLogin);

    @POST(SERVER_FORGET_PASSWORD)
    Call<JsonResponse> forget_password(@Body SendLogin sendLogin);

    @FormUrlEncoded
    @POST(SERVER_EXAM_RESULT)
    Call<JsonResponse> stu_grade(@Header("Authorization") String token,@Field("student_code") String studentCode);

    @POST(SERVER_CHANGE_PASS)
    Call<JsonResponse> edit_pass(@Header("Authorization") String token,@Body SendEditPass editPass);

    @POST(SERVER_ACTIVITY)
    Call<JsonResponse> show_activities(@Header("Authorization") String token);

    @POST(SERVER_ACTIVITY_PARTICIPATE)
    Call<JsonResponse> activity_participate(@Header("Authorization") String token , @Body SendParticipate participate);


    @POST(SERVER_GET_MESSAGE)
    Call<JsonResponse> get_message(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST(SERVER_SEND_MESSAGE)
    Call<JsonResponse> send_message(@Header("Authorization") String token,@Field("message") String message);

    @POST(SERVER_NOTIFICATION_AFTER)
    Call<JsonResponse> notification_after(@Header("Authorization") String token);
}
