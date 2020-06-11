static int finalDiameter;
      public static int diameter1(Node node){

          int h = -1;
          int lh = -1, slh = -1;
          for(Node child : node.children){
            int ch = diameter1(child);
            h= Math.max(h,ch);

            if(ch > lh){
                // largest & second largest height update
                slh = lh;
                lh = ch;
            }else if(ch > slh){
                // second largest height update
                slh =ch;
            }
          }
          // diameter cam be calculated for the node
            int diameter = lh + slh + 2;
            if(diameter > finalDiameter){
              finalDiameter = diameter;
            }

          h += 1;

          return h;
      }
// max dist. b/w any two nodes
