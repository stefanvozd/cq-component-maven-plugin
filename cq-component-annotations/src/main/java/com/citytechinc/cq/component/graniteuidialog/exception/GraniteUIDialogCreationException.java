package com.citytechinc.cq.component.graniteuidialog.exception;

public class GraniteUIDialogCreationException extends Exception {

    public GraniteUIDialogCreationException(String m) {
        super(m);
    }

    public GraniteUIDialogCreationException(Exception e) {
        super(e);
    }

    public GraniteUIDialogCreationException(String m, Exception e) {
        super(m, e);
    }
}
