package pl.obol.v1;

import javax.sound.midi.*;

public class App1 {

    public static void main(String[] args) {
        App1 app = new App1();

        app.play();
    }

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track1 = sequence.createTrack();
            ShortMessage a = new ShortMessage();
            ShortMessage b = new ShortMessage();
            a.setMessage(144,1,44,100);
            b.setMessage(144,2,44,100);
            MidiEvent noteA = new MidiEvent(a,1);
            MidiEvent noteB = new MidiEvent(b,16);
            track1.add(noteA);
            track1.add(noteB);

            sequencer.setSequence(sequence);
            sequencer.start();


        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }

    }
}
