package com.sample;

import java.awt.*;
import javax.swing.*;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.logger.*;

public class Main {

    public static final void main(String[] args) {
        try {
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");
            kSession.fireAllRules();
            kLogger.close();
        } 
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static class ConfirmDialog extends JFrame {
        public ConfirmDialog() {
            getContentPane().setBackground(new Color(238, 232, 170));
            getContentPane().setLayout(null);
            setTitle("Confirm Dialog in Frame");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setSize(450, 300);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
        }
    }

    public static class Rule {
    	public String q;
    	public String a;
    	public Rule(String q, String a) {
    		this.q = q;
    		this.a = a;
    	}
    }
}
