/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.stores;

import com.datastax.driver.core.utils.Bytes;
import java.nio.ByteBuffer;

/**
 *
 * @author Administrator
 */
public class Pic {

    private ByteBuffer bImage = null;
    private int length;
    private String type;
    private java.util.UUID UUID=null;
    private String SUUID = null;
    private String name = null;
    
    public void Pic() {

    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setUUID(java.util.UUID UUID){
        this.UUID =UUID;
    }
    public void setSUUID(){
        SUUID = UUID.toString();
    }
    public void setPic(ByteBuffer bImage, int length,String type, String name) {
        this.bImage = bImage;
        this.length = length;
        this.type=type;
        this.name = name;
    }
    
    public void setLength(int length)
    {
        this.length = length;
        
    }
    
    public String getSUUID()
    {
        return SUUID;
    }

    public ByteBuffer getBuffer() {
        return bImage;
    }

    public int getLength() {
        return length;
    }
    
    public String getType(){
        return type;
    }

    public byte[] getBytes() {
         
        byte image[] = Bytes.getArray(bImage);
        return image;
    }

}
