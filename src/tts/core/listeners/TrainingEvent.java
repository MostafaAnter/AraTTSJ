/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.listeners;

/**
 *كي لا تكون عملية التدريب ثابتة تكون مهمة هذا الصف حمل معلومات عن مقادر التقدم في عملية التدريب
 */
public class TrainingEvent {
    private double progress;

    
    public TrainingEvent(double progress) {
        this.progress = progress;
    }

    /**
     * معرفة آخر قيمة للتدريب و تكون من 100
     * @return آخر قيمة للتدريب
     */
    public double getProgress() {
        return progress;
    }
    
    
}
