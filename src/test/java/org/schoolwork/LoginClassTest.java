package org.schoolwork;

import org.junit.Assert;
import org.junit.Test;

public class LoginClassTest {

    @Test
    public void getUsername() {
        LoginClass l = new LoginClass("DonaldDuck", "Goofy");
        Assert.assertEquals("DonaldDuck", l.getUsername());
    }

    @Test
    public void setUsername() {
        LoginClass l = new LoginClass("DonaldDuck", "Goofy");
        l.setUsername("MickyMouse");
        Assert.assertEquals("MickyMouse", l.getUsername());
    }

    @Test
    public void getPassword() {
        LoginClass l = new LoginClass("DonaldDuck", "Goofy");
        Assert.assertEquals("Goofy", l.getPassword());
    }

    @Test
    public void setPassword() {
        LoginClass l = new LoginClass("DonaldDuck", "Goofy");
        l.setPassword("Pluto");
        Assert.assertEquals("Pluto", l.getPassword());
    }
}
