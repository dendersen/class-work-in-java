package dk.mtdm.visual;

import javax.sound.midi.MidiEvent;

import dk.mtdm.storage.CardObject;
import processing.core.PGraphics;

public class Board {
    CardObject[] middelcards;

    public Board() {
    }

    public void setMiddelCards(CardObject[] cards) {
        middelcards = cards;
    }

    public void show(PGraphics g) {
        for (int i = 0; i < middelcards.length; i++) {
        }
    }
}
