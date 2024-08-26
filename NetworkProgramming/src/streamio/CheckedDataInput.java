/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamio;

import java.io.DataInput;
import java.io.IOException;
import java.util.zip.Checksum;

/**
 *
 * @author DarkShadowDemon200x
 */
public class CheckedDataInput {

    private Checksum cksum;
    private DataInput in;

    public CheckedDataInput(DataInput in, Checksum cksum) {
        this.cksum = cksum;
        this.in = in;
    }

    public byte readByte() throws IOException {
        byte b = in.readByte();
        cksum.update(b);
        return b;
    }

    public void readFully(byte[] b) throws IOException {
        in.readFully(b, 0, b.length);
        cksum.update(b, 0, b.length);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        in.readFully(b, off, len);
        cksum.update(b, off, len);
    }

    public Checksum getChecksum() {
        return cksum;
    }
}
