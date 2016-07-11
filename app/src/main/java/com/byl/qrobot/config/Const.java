package com.byl.qrobot.config;

import android.os.Environment;

public class Const {

    public static final String FILE_VOICE_CACHE = Environment.getExternalStorageDirectory() + "/qrobot/voice/";

    public static final String XF_VOICE_APPID="573945a6";//讯飞语音appid
    public final static String XF_SET_VOICE_RECORD="VOICE_RECORD";//录音语言
    public final static String XF_SET_VOICE_READ="XF_SET_VOICE_READ";//朗读语言

    public final static String IM_VOICE_TPPE="IM_VOICE_TPPE";//语音聊天形式
    public final static String IM_SPEECH_TPPE="IM_SPEECH_TPPE";//聊天回复是否直接朗读


    // 资讯Type标识常量 End


    public static final String MSG_TYPE_TEXT="msg_type_text";//文本消息
    public static final String MSG_TYPE_IMG="msg_type_img";//图片
    public static final String MSG_TYPE_VOICE="msg_type_voice";//语音
    public static final String MSG_TYPE_LOCATION="msg_type_location";//位置
    public static final String MSG_TYPE_MUSIC="msg_type_music";//音乐
    public static final String MSG_TYPE_LIST="msg_type_list";//新闻

    //机器人api，注意key为本人所有，使用时请到图灵机器人官网注册http://www.tuling123.com
    public static final String ROBOT_URL="http://www.tuling123.com/openapi/api";
    public static final String ROBOT_KEY="24cf362cd4b88f7b8ef3cdf207c8765f";


    /**
     * 分隔符
     */
    public final static String  SPILT = "☆";

}
