/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.listeners;

/**
 * عند كل تغيير في حالة التدريب يتم استدعاء هذا الصف لعرض التغييرات
 */
public interface TrainingListener {

    void trainingStatusChanged(TrainingEvent e);
}
