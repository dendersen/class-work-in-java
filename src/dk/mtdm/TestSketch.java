package dk.mtdm;

import com.jogamp.nativewindow.WindowClosingProtocol.WindowClosingMode;

import processing.core.PApplet;

public class TestSketch extends PApplet{
  public PApplet getPApplet() {
    return this;
  }
  @Override
  public void settings() {
    size(100, 100);
  }
  @Override
  public void exitActual(){
    if (getGraphics().isGL()){
      final com.jogamp.newt.Window w = (com.jogamp.newt.Window) getSurface().getNative();
      w.setDefaultCloseOperation(WindowClosingMode.DISPOSE_ON_CLOSE);
    }
  }
}
