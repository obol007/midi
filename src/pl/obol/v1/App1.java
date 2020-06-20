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
            ShortMessage change = new ShortMessage();
            ShortMessage a = new ShortMessage();
            ShortMessage b = new ShortMessage();
            ShortMessage c = new ShortMessage();
            ShortMessage d = new ShortMessage();
            ShortMessage e = new ShortMessage();
            ShortMessage a1 = new ShortMessage();
            ShortMessage b1 = new ShortMessage();
            ShortMessage c1 = new ShortMessage();
            ShortMessage d1 = new ShortMessage();
            ShortMessage e1 = new ShortMessage();

            change.setMessage(192,1,20,0);
            MidiEvent changeInstrument = new MidiEvent(change,1);
            track1.add(changeInstrument);

            a.setMessage(144,1,44,100);
            b.setMessage(144,1,46,100);
            c.setMessage(144,1,49,100);
            d.setMessage(144,1,54,100);
            e.setMessage(144,1,53,100);
            a1.setMessage(128,1,44,100);
            b1.setMessage(128,1,46,100);
            c1.setMessage(128,1,48,100);
            d1.setMessage(128,1,54,100);
            e1.setMessage(128,1,53,100);

            MidiEvent noteA = new MidiEvent(a,1);
            MidiEvent noteB = new MidiEvent(b,4);
            MidiEvent noteC = new MidiEvent(c,6);
            MidiEvent noteD = new MidiEvent(d,8);
            MidiEvent noteE = new MidiEvent(e,20);
            MidiEvent noteA1 = new MidiEvent(a1,30);
            MidiEvent noteB1 = new MidiEvent(b1,30);
            MidiEvent noteC1 = new MidiEvent(c1,30);
            MidiEvent noteD1 = new MidiEvent(d1,20);
            MidiEvent noteE1 = new MidiEvent(e1,30);
            track1.add(noteA);
            track1.add(noteB);
            track1.add(noteC);
            track1.add(noteD);
            track1.add(noteE);
            track1.add(noteA1);
            track1.add(noteB1);
            track1.add(noteC1);
            track1.add(noteD1);
            track1.add(noteE1);

            sequencer.setSequence(sequence);
            sequencer.start();



        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }

    }
}
