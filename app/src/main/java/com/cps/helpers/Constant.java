package com.cps.helpers;

public class Constant {

    public static final String SERVER_BASE_URL = "https://www.cps-education.com/";
    public static final String SERVER_BASE_API = SERVER_BASE_URL + "api/";
    public static final String SERVER_EVENT_NEWS = SERVER_BASE_API +"events_news";
    public static final String SERVER_GALLERY = SERVER_BASE_API +"show_gallery";
    public static final String SERVER_CONTACTUS = SERVER_BASE_API +"contact_us";
    public static final String SERVER_ADMISSION_DATA = SERVER_BASE_API +"admission_data";
    public static final String SERVER_ADMISSION_MEDIA = SERVER_BASE_API +"admission_media";
    public static final String SERVER_NOTIFICATION_BEFORE = SERVER_BASE_API +"notification_before";

    public static final String SERVER_BASE_URL_LOGIN = SERVER_BASE_URL+"cps_system/";
    public static final String SERVER_BASE_API_LOGIN = SERVER_BASE_URL_LOGIN + "api/";
    public static final String SERVER_LOGIN = SERVER_BASE_API_LOGIN +"login";
    public static final String SERVER_FORGET_PASSWORD = SERVER_BASE_API_LOGIN +"forget_password";
    public static final String SERVER_EXAM_RESULT = SERVER_BASE_API_LOGIN +"student_exam_result";
    public static final String SERVER_CHANGE_PASS = SERVER_BASE_API_LOGIN +"change_password";
    public static final String SERVER_ACTIVITY = SERVER_BASE_API_LOGIN +"show_activities";
    public static final String SERVER_ACTIVITY_PARTICIPATE = SERVER_BASE_API_LOGIN +"activity_participate";
    public static final String SERVER_GET_MESSAGE = SERVER_BASE_API_LOGIN +"get_message";
    public static final String SERVER_SEND_MESSAGE = SERVER_BASE_API_LOGIN +"send_message";
    public static final String SERVER_NOTIFICATION_AFTER = SERVER_BASE_API_LOGIN +"notification_after";

    public static final String SERVER_MEDIA_EVENT_NEWS = SERVER_BASE_URL + "public/web/data/event_news/images/";
    public static final String SERVER_MEDIA_GALLERY = SERVER_BASE_URL + "public/web/data/gallery/";
    public static final String SERVER_MEDIA_ACTIVITY = SERVER_BASE_URL + "public/web/data/activity/";


    public static final int STATUS_CODE_SUCCESS = 200;
    public static final int STATUS_CODE_ERROR_DATA = 410;
    public static final int STATUS_CODE_ERROR_TOKEN = 405;
}
