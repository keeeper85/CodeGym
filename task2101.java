package com.codegym.task.task21.task2101;

/* 
Determine the network address
1) The IP address and subnet mask are given. You need to calculate the network address: implement the getNetAddress method.
Use the bitwise AND operator.

Example:
IP address: 11000000 10101000 00000001 00000010 (192.168.1.2)
Subnet mask: 11111111 11111111 11111110 00000000 (255.255.254.0)
Network address: 11000000 10101000 00000000 00000000 (192.168.0.0)

2) Implement the print method, which will display the data in binary on the console.
If the IP address is 192.168.1.2, then "11000000 10101000 00000001 00000010" should be displayed
3) The main method is not tested


Requirements:
1. The getNetAddress method must calculate and return the network address based on the passed arguments (IP address and subnet mask).
2. The getNetAddress method must be static and public.
3. The print method must be static and public.
4. The print method must convert the passed IP address to binary and display it (as per the task conditions).

*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[4];
    }

    public static void print(byte[] bytes) {
    }
}
