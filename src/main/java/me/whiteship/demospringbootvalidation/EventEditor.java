package me.whiteship.demospringbootvalidation;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Event event = (Event)getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
//thread-safe 하지 않다. 프로퍼티 에디터 구현체들은 여러 스레드 공유해서 쓰면안된다. 빈으로 등록해서 쓰면 안된다.
//프로퍼티에디터는 빈으로 등록하면 안된다. 그냥 빈이 아니라 스레드 스콥에 빈으로 만들어서 쓰면 상관없다.
