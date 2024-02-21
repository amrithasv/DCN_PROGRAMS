import java.math.*;
import java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.*;
class leaky{
	public static void main(String[]args){
		int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0;
		int packet[]=new int[100];
		Scanner in=new Scanner(System.in);
		System.out.print("enter the bucket size:\t");
		b_size=in.nextInt();
		System.out.print("enter the output rate:\t");
		o_rate=in.nextInt();
		System.out.print("enter the number of seconds to simulate:\t");
		nsec=in.nextInt();
		Random rand=new Random();
		for(i=0;i<nsec;i++)
			packet[i]=(rand.nextInt(1000));
		System.out.print("seconds    received    sent    left   dropped\n");
		System.out.println("\n...............................................................");
		for(i=0;i<nsec;i++){
			p_remain+=packet[i];
			if(p_remain>b_size){
				drop=p_remain-b_size;
				p_remain=b_size;
				System.out.print(i+1+"          ");
				System.out.print(packet[i]+"       \t");
				mini=Math.min(p_remain,o_rate);
				System.out.print(mini+"    \t");
				p_remain=p_remain-mini;
				System.out.print(p_remain+"      ");
				System.out.print(drop+"      ");
				System.out.println("      ");
				drop=0;
			}
		}	
		while(p_remain!=0){
			if(p_remain>b_size){
				drop=p_remain-b_size;
			}
			mini=Math.min(p_remain,o_rate);
			System.out.print("        "+p_remain+"        "+mini);
			p_remain=p_remain-mini;
			System.out.println("        "+p_remain+"        "+drop);
			drop=0;
		}
	}
}	

