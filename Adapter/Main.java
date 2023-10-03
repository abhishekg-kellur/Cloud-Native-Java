package Adapter;

interface MediaPlayer {
	void play(String fileName);
}

interface AdvancedMediaPlayer {
	void playVideo(String fileName);
}

class VLCPlayer implements AdvancedMediaPlayer {

	@Override
 	public void playVideo(String fileName) {
		System.out.println("Playing MP4 file: " + fileName);
 }
}

class MP4Player implements AdvancedMediaPlayer {

	@Override
	public void playVideo(String fileName) {
		System.out.println("Playing MP4 file: " + fileName);
 }
}

class AudioPlayer implements MediaPlayer {
	public void play(String file) {
		System.out.println("Playing audio" + file);
	}
}

class AdapterMedia implements MediaPlayer {
    private AdvancedMediaPlayer AMP;

    public AdapterMedia(AdvancedMediaPlayer a) {
        this.AMP = a;
    }

    @Override
    public void play(String fileName) {
    	System.out.println("AudioVideo file:" + fileName);
    	AMP.playVideo(fileName);
    }
}

public class Main {
	public static void main(String[] args) {
	     MediaPlayer player = new AudioPlayer();
	     player.play("song.mp3");
	     player = new AdapterMedia(new VLCPlayer());
	     player.play("movie.mp4");
	     player = new AdapterMedia(new MP4Player());
	     player.play("movie.mkv");
	}
}
