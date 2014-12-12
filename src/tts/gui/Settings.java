package tts.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * الهدف من هذا الصف حو حفظ بعض الإعدادات البسيطة للواجهة الرسومية و البرنامج
 */
public class Settings {

    private static Settings set;
//للقراة و الكتابة من و إلى ملف الإعدادات
    FileInputStream in;
    FileOutputStream out;
    //الإعدادت
    Properties props = new Properties();

    /**
     * يجب أن يتواجد نسخة واحدة فقط من هذا الصف لذلك نستخدم Singleton Design
     * Pattern
     */
    private Settings() {
        //فتح الملف الذي يحتوي الإعدادات

        try {
            //للقراة و الكتابة من و إلى ملف الإعدادات
            in = new FileInputStream("set.conf");
            //تحميل الإعدادات
            props.load(in);
            out = new FileOutputStream("set.conf",true);

        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * قراءة مسار MBROLA
     */
    public String getMBROLA() {
        return props.getProperty("MBROLA", "");
    }

    /**
     * تعديل مسار MBROLA
     *
     */
    public void setMBROLA(String path) {
        try {
            props.setProperty("MBROLA", path);
            props.store(out, "");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * قراءة مسار Phoneme DB
     *
     */
    public String getPhonemeDB() {
        return props.getProperty("PhonemDB", "");
    }

    /**
     * تعديل مسار Phoneme DB
     *
     */
    public void setPhonemeDB(String path) {
        try {
            props.setProperty("PhonemDB", path);
            props.store(out, "");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * الحصول على إعدادات النظام
     */
    public static Settings getSettings() {
        if (set == null) {
            set = new Settings();
        }
        return set;
    }
}
