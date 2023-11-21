package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberViewConsole implements DrawNumberView {
    private DrawNumberController controller;
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";


    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;    
    }

    @Override
    public void start() {
        //Nothing
    }

    @Override
    public void result(DrawResult res) {
       switch (res) {
        case YOURS_HIGH,YOURS_LOW -> System.out.println(res.getDescription());        
        case YOU_WON -> System.out.println(res.getDescription()+NEW_GAME);
        case YOU_LOST -> System.out.println(res.getDescription()+"Lost");
        
        default -> throw new IllegalStateException();
       }
       controller.resetGame();
    }
    
}
