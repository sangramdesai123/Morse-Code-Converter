/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class chk {
    
    
    static String answer=new String();
   static  String path=new String();
    public chk(String s)
    {
        path=s;
      
    }
   
    public static void main(String[] args) throws IOException {
        int width = 963;    //width of the image
        int height = 640;   //height of the image

        // For storing image in RAM
        BufferedImage image = null;
       
         //static String answer=new String();
        // READ IMAGE
        try {
            File input_file = new File("C:\\Users\\Tushar\\Desktop\\test images\\sangram.jpg"); //image file path
            /* create an object of BufferedImage type and pass
               as parameter the width,  height and image int
               type.TYPE_INT_ARGB means that we are representing
               the Alpha, Red, Green and Blue component of the
               image pixel using 8 bit integer value. */
            //image = new BufferedImage(width, height,
            //    BufferedImage.TYPE_INT_ARGB);
            // Reading input file
            image = ImageIO.read(input_file);
            width = image.getWidth();
            height = image.getHeight();

            System.out.println("Reading complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        MakeItDone(image);

        // Output file path
    
        boolean start = false, end = false;
        int len = 0;
        ArrayList<Integer> length = new ArrayList<Integer>();
        ArrayList<Integer> space_array = new ArrayList<Integer>();
        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<Integer> height_all = new ArrayList<Integer>();
        ArrayList<Integer> ratios = new ArrayList<Integer>();

        // int length[]=new int[6];
        // int space_array[]=new int[7];
        int space_count = 0;
        //int index=0;
        for (int i = 0; i < width; i++) {
            if (isDotPresent(i, height, image)) {

                if (!start) {
                    position.add(i);
                    space_array.add(space_count);
                    space_count = 0;
                    start = true;

                }
                len++;

            } else {
                if (start) {
                    position.add(i);
                    start = false;
                    length.add(len);
                    len = 0;
                    //index++;
                }
                space_count++;

            }

        }
        space_array.add(space_count);
         try
        {
            // Output file path
            File output_file = new File("C:\\Users\\Tushar\\Desktop\\bw.jpg");
 
            // Writing to file taking type and path as
            ImageIO.write(image, "jpg", output_file);
 
            System.out.println("Writing complete.");
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
        
        System.out.println("pos"+position);
        System.out.println("len"+length);

        Height(height_all, position, height, image);
        
        int r1 = 0, r2 = 0;
        for (int i = 0; i < length.size(); i++) {
            r1 = length.get(i) / height_all.get(i);
            r2 = height_all.get(i) / length.get(i);

            ratios.add(Math.max(r1, r2));
        }
        //For spacinng logic
        space_array.remove(0);
        space_array.remove(space_array.size() - 1);

        boolean whereIsSpace[] = new boolean[space_array.size()];
        Arrays.fill(whereIsSpace, false);
            isthereSpace(space_array, whereIsSpace);
            System.out.println("space array"+ space_array);
            
            for(int i=0;i<whereIsSpace.length;i++)
            System.out.print(whereIsSpace[i]+" ");
            System.out.println("");
        
        
 StringBuilder ans=new StringBuilder();
 for(int i=0;i<ratios.size();i++)
 {
     if(ratios.get(i)>1) ans.append("-");
     else ans.append(".");
         
 }
 for(int i=0,j=0;i<whereIsSpace.length;i++)
 {
     if(whereIsSpace[i]) 
     {
         ans.insert(i+1+j," ");j++;
     }
 }
        System.out.println(ans); //add these to gui anser main
        answer =new String(ans);       
    }//main() ends here

    static void isthereSpace(ArrayList<Integer> space_array,boolean whereIsSpace[])
    {
        int space_len=0,normal=0;
        int index=1;
        if(space_array.size()==0) return;
        int start=space_array.get(0);
        while(index<space_array.size()&&!(space_array.get(index)>2*start||2*space_array.get(index)<start))
        {
            index++;
        }
        if(index!=space_array.size())
        {
            if(space_array.get(index)>2*start)
            {
                space_len=space_array.get(index);
                normal=start;
            }
            else
            {
                           
                    space_len=start;
                    normal=space_array.get(index);
                    
                
                    
            }
        }
        else
        {
            return;
        }
        int cmp=0;
        int minspace=(int)(0.5*space_len);
        for(int i=0;i<space_array.size();i++)
        {
            cmp=space_array.get(i);
            
            if(cmp>minspace)
                whereIsSpace[i]=true; 
        }
        return ;
            
    }
    
    static boolean isDotPresent(int width, int height, BufferedImage image) {
        for (int i = 0; i < height; i++) {
            int p = image.getRGB(width, i);
            p = p << 8;
            p = p >>> 8;

            if (p < 0xACACAF) {
                return true;
            }

        }
        return false;
    }

    static boolean isDotPresent(int y, int first, int second, BufferedImage image) {
        int p = 0;
        for (int x = first; x <= second; x++) {
            p = image.getRGB(x, y);
            p = p << 8;
            p = p >>> 8;
            if (p < 0xACACAF) {
                return true;
            }

        }
        return false;
    }

    static void Height(ArrayList<Integer> height_all, ArrayList<Integer> position, int h, BufferedImage image) {

        int first_pos = 0, second_pos = 0;
        Iterator<Integer> it = position.iterator();
        int p = 0;

        while (it.hasNext()) {
            first_pos = it.next();
            second_pos = it.next();
            int temp_height = 0;

            for (int j = 0; j < h; j++) {

                if (isDotPresent(j, first_pos, second_pos, image)) {
                    temp_height++;
                }

            }
            height_all.add(temp_height);

        }

    }

    static void MakeItDone(BufferedImage image) {
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int p = image.getRGB(i, j);
                p = p << 8;
                p = p >>> 8;
                r = p >> 16 & 0xff;;
                g = p >> 8 & 0xff;
                b = p & 0xff;
                if (((r + g + b) / 3) < 75) { //here i made change 
                    image.setRGB(i, j, 0); //set Black
                } else {
                    image.setRGB(i, j, 16777215);
                }
            }
        }
    }

}//cla