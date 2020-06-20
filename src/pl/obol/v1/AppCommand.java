package pl.obol.v1;

import javax.sound.midi.*;

public class AppCommand {

    public static void main(String[] args)  {

        AppCommand app = new AppCommand();

        if(args.length < 2){
            System.out.println("Please give two arguments... ");
        }else{
            int instrument = Integer.parseInt(args[0]);
            int nuta = Integer.parseInt(args[1]);

            app.play(instrument,nuta);
        }
    }

    private void play(int instrument, int nuta)  {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track1 = sequence.createTrack();

            MidiEvent event = null;
            ShortMessage m1 = new ShortMessage();
            m1.setMessage(192,1,instrument,0);
            MidiEvent zmienInstrument = new MidiEvent(m1, 1);
            track1.add(zmienInstrument);

            ShortMessage m2 = new ShortMessage();
            m2.setMessage(144,1, nuta, 100);
            MidiEvent dodajNute = new MidiEvent(m2,16);
            track1.add(dodajNute);

            sequencer.setSequence(sequence);
            sequencer.start();

        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
}
