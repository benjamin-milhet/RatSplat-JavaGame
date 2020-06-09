package GVB;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class son {
    public void test(){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("sound/death.wav")));
            clip.start();
        }catch (Exception exc){exc.printStackTrace();}
    }
}
