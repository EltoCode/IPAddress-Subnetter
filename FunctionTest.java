/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Testing;

import java.util.Scanner;

/**
 *
 * @author Elton John Fernandes
 */
public class FunctionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        String IP;
        String sNet;
        
        
        /*
        System.out.println("Enter Given IP Address Block");
        IP =  input.next();
        System.out.println("Enter Given Subnet Address");
        sNet =  input.next();
        */
        calcIPAddrsSpace("192.168.4.24", "255.255.255.0");
        
    }
    
    public static int calcIPAddrsSpace(String ipAddrs, String subnet)
    {
        System.out.println("function entered");
        
        int totalIPs = 0;
        String[] buffer;
        
        //Conversion Code//
        
        //turning the string IP to usable int using a buffer
        buffer = ipAddrs.split("\\.");
        
        
        int[] ipAddrsParts = new int[4];
        
        for (int i = 0;i<4;i++)
            ipAddrsParts[i] = Integer.parseInt(buffer[i]);
        
        //turning the string subnet to usable int using a buffer
        buffer = subnet.split("\\.");
        
        int[] subnetParts = new int[4];
        
        for (int i = 0;i<4;i++)
            subnetParts[i] = Integer.parseInt(buffer[i]);
        
        
        System.out.println("\nyour IP and subnet");
        //Ouputing conv values
        for(int part : ipAddrsParts)
            System.out.print(part+".");
        System.out.println();
        for(int part : subnetParts)
            System.out.print(part+".");
        
        
        //Calculation Code//
        
        //performing bitwise and
        System.out.println("\n\nbitwise and:\n" + (ipAddrsParts[0]&subnetParts[0])
                            +"."+ (ipAddrsParts[1]&subnetParts[1])
                            +"."+ (ipAddrsParts[2]&subnetParts[2])
                            +"."+ (ipAddrsParts[3]&subnetParts[3]) );
        
        
        
        String[] binIpARR = new String[4];
        
        //Standardizing into 8 bit by adding zeroes where required
        for(int i=0;i<4;i++)
        {
            binIpARR[i] = Integer.toBinaryString(ipAddrsParts[i]&subnetParts[i]);
            
            while(binIpARR[i].length()!=8)
                binIpARR[i] = "0" + binIpARR[i];
             
        }
        
        
        //Making into Usable binary strings
        String binIP = binIpARR[0] + binIpARR[1] + binIpARR[2] + binIpARR[3];
        
        String binSNet = new String();
        for(int i=0;i<4;i++)  //Used for 8bit standardizing 
        {
            String sNBuffer = Integer.toBinaryString(subnetParts[i]);
            
            while(sNBuffer.length()!=8)
                sNBuffer = "0" + sNBuffer;
            
            binSNet = binSNet + sNBuffer;
        
        }
        
        System.out.println("\nbinary Subnet:\n" + binSNet);
        
        System.out.println("\n\nbinIP="+binIP);
        
        for(String part : binIpARR)
            System.out.print(part + ".");
        
        
        
        int sNetCount = binSNet.length() - 1;
        int zeroNum = 0;
        while(binSNet.charAt(sNetCount) == '0')
        {
            sNetCount--;
            zeroNum++;
        }
        
        System.out.println("\nzeroNum="+zeroNum );
        System.out.print("\n\nAvailible Ip Address space: ");
        System.out.println(Math.pow(2, zeroNum) - 2);
        
        return totalIPs;
    }
    
}
