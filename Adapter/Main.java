package Adapter;

interface MediaPlayer {
 void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
 void playVlc(String fileName);
 void playMp4(String fileName);
}

class VKPlayer implements AdvancedMediaPlayer {
 @Override
 public void playVlc(String fileName) {
     // Do nothing (not supported)
 }

 @Override
 public void playMp4(String fileName) {
     System.out.println("Playing MP4 file: " + fileName);
 }
}

class Mp4Player implements AdvancedMediaPlayer {
 @Override
 public void playVlc(String fileName) {
     // Do nothing (not supported)
 }

 @Override
 public void playMp4(String fileName) {
     System.out.println("Playing MP4 file: " + fileName);
 }
}

class AudioPlayer implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    public AudioPlayer() {
        advancedMusicPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid media type: " + audioType + " format not supported");
        }
    }
}

public class Main {
 public static void main(String[] args) {
     MediaPlayer audioPlayer = new AudioPlayer();

     audioPlayer.play("mp3", "song.mp3");
     audioPlayer.play("vlc", "song.vlc");
     audioPlayer.play("mp4", "song.mp4");
     audioPlayer.play("avi", "song.avi");
 }
}
