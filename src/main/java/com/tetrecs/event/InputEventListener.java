package com.tetrecs.event;

import com.tetrecs.component.ViewData;
import com.tetrecs.component.DownData;

public interface InputEventListener {

    DownData onDownEvent(MoveEvent event);

    ViewData onLeftEvent(MoveEvent event);

    ViewData onRightEvent(MoveEvent event);

    ViewData onRotateEvent(MoveEvent event);

    void createNewGame();
}
