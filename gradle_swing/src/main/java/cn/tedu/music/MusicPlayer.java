package cn.tedu.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author restyhap
 * @date 2019年03月05日 09:13
 * <pre>
 *
 * </pre>
 */

public class MusicPlayer {
    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        File file = new File("E:\\IdeaWorkSpaces\\gradle_tedu\\gradle_swing\\src\\main\\resources\\by.mp3");
        play(file);


    }

    private static void play(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //获得音乐文件
       
        //获得音乐文件输入流
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        //获取文件流的格式化方式
        AudioFormat audioFormat = audioInputStream.getFormat();

        System.out.println(audioFormat.toString());
        System.out.println("***************************");
        if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16, audioFormat.getChannels(), audioFormat.getChannels() * 2, audioFormat.getSampleRate(), false);

            audioInputStream = AudioSystem.getAudioInputStream(audioFormat, audioInputStream);
        }

        System.out.println(audioFormat.toString());

        //打开设备
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);

        SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

        sourceDataLine.open(audioFormat);

        sourceDataLine.start();

        //循环播放

        int cnt;
        byte b[] = new byte[1024];
        while ((cnt = audioInputStream.read(b, 0, b.length)) != -1) {
            if (cnt > 0) {
                sourceDataLine.write(b, 0, cnt);
            }
        }

        sourceDataLine.drain();
        sourceDataLine.close();
    }
}