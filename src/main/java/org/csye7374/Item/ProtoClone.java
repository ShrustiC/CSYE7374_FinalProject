package org.csye7374.Item;

import java.util.HashMap;
import java.util.Map;

public class ProtoClone implements Cloneable{
	 
     public ProtoClone() {
         try {
             throw new CloneNotSupportedException();
         } catch(Exception e) {
             e.printStackTrace();
         }
     }
}