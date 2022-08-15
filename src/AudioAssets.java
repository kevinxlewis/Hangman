import javax.sound.sampled.*;
import java.io.*;


public class AudioAssets {
    public String backgroundMusicPath = ".src/background_music.wav";
    public Clip backgroundClip;
    public AudioInputStream backgroundAudioStream;



    public void playBackgroundMusic() {
        try {
            backgroundAudioStream = AudioSystem.getAudioInputStream(new File(backgroundMusicPath));
            backgroundClip.open(backgroundAudioStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
