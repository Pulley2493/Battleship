enum Direction { HORIZONTAL, VERTICAL };
class Point
{
    int x_coord;
    int y_coord;

    public Point() //Initialize (x,y) for Point object
    {
        this.x_coord = 0;
        this.y_coord = 0;
    }
    public Point(int x_coord, int y_coord)
    {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }
}



class Board{
		char[][] board_array;
		char[] Id = {'A','B','C','D','P'};
		int[] size_ship={5,4,3,3,2};
		
	Board(){//Pass the object of game class and initialize board_array 2-D matrix
		board_array = new char[10][10];

		for(int i=0; i<row; i++)   //replace inside constructor's definition with new initialization via Game class object
		{
			for(int j=0; j<column; j++)
			{
				board_array[i][j] = '.';
			}
		}
		}
	void display(boolean shotsOnly)
	{
		System.out.print("   ");
		for(int i=0; i<10; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
	
		for(int i=0; i<10; i++)
		{
			System.out.print(i + "  ");

			for(int j=0; j<10; j++)
			{
				if(shotsOnly == false)
				{
					System.out.print(board_array[i][j] + " ");
				}
			
				else if(shotsOnly == true)
				{
					if((board_array[i][j] == 'A') || (board_array[i][j] == 'B') || (board_array[i][j] == 'C') || (board_array[i][j] == 'D') || (board_array[i][j] == 'P'))
				{
					System.out.print(". ");
				} else{
					System.out.print(board_array[i][j] + " ");
				}}
			}
			System.out.println();
		}
		
	}
	boolean placeShip(Point p,int shipId,Direction dir){
		boolean status = true;//to check whether the ship has been placed or not
		outerloop:
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(Id[shipId]==board_array[i][j]){
					status = false;
					break outerloop;
					}
				}
			}
		if(status){//checking if ship is not fitted on the board previously
			//First checking enum values
			if(dir==Direction.VERTICAL){
				int set=1;//checking bottom first
				if(set==1){
					if((p.x_coord+size_ship[shipId])<10){
					for(int i=0;i<size_ship[shipId];i++)//checking index limit feasiblity for access
						{
						if(board_array[p.x_coord+i][p.y_coord]!='.'){
							set=0;
							break;
							}
						}
					if(set==1){//changing board appropriatly
						for(int i=0;i<size_ship[shipId];i++)
						{
							board_array[p.x_coord+i][p.y_coord]=Id[shipId];
						}
						}
					}else{
						set=0;
						}
					}
				if(set!=1){
					set=1;
					 if((p.x_coord-size_ship[shipId])>-1){
                                        for(int i=0;i<size_ship[shipId];i++)//checking upper/top side
                                                {
                                                if(board_array[p.x_coord-i][p.y_coord]!='.'){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)
                                                {
                                                        board_array[p.x_coord-i][p.y_coord]=Id[shipId];
						}
                                                }
                                        }else{
                                                set=0;
                                                }

					
					}
				 if(set==1)status=true;
                        		else{
                                		status=false;
                                	}

			}
			if(dir==Direction.HORIZONTAL){
			//checking for right side
				int set=1;
                                if(set==1){
                                        if((p.y_coord+size_ship[shipId])<10){
                                        for(int i=0;i<size_ship[shipId];i++)//validating index limits for required size
                                                {
                                                if(board_array[p.x_coord][p.y_coord+i]!='.'){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){//if limit founds feasible then changing the board appropriatly
                                                for(int i=0;i<size_ship[shipId];i++)
                                                {
                                                        board_array[p.x_coord][p.y_coord+i]=Id[shipId];
                                                }
                                                }
                                        }else{
                                                set=0;
                                                }
                                        }
                                if(set!=1){
                                        set=1;
                                         if((p.y_coord-size_ship[shipId])>-1){
                                        for(int i=0;i<size_ship[shipId];i++)//checking left side
                                                {
                                                if(board_array[p.x_coord][p.y_coord-i]!='.'){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)
                                                {
                                                        board_array[p.x_coord][p.y_coord-i]=Id[shipId];
                                                }
                                                }
                                        }else{
                                                set=0;
                                                }
	
					 }
                                 if(set==1)status=true;
                                        else{
                                                status=false;
                                        }

                        	}
			if(dir!=Direction.HORIZONTAL && dir!=Direction.VERTICAL){
				status=false;
				}
			}

			return status;
		}
	boolean unplaceShip(Point p,int shipId,Direction dir){
		boolean status=false;
		if(shipId>=0 && shipId<=4){
			if(dir==Direction.VERTICAL){
				int set=1;
                                if(set==1){
					if((p.x_coord+size_ship[shipId])<10){
                                        for(int i=0;i<size_ship[shipId];i++)//checking bottom side
                                                {
                                                if(board_array[p.x_coord+i][p.y_coord]!=(Id[shipId])){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)
                                                {
                                                        board_array[p.x_coord+i][p.y_coord]='.';
                                                }
                                                }
                                        }else{
                                                set=0;
                                                }
                                        }
                                if(set!=1){
                                        set=1;
                                         if((p.x_coord-size_ship[shipId])>-1){
                                        for(int i=0;i<size_ship[shipId];i++)//checking upper side
                                                {
                                                if(board_array[p.x_coord-i][p.y_coord]!=(Id[shipId])){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)
						  {
                                                        board_array[p.x_coord-i][p.y_coord]='.';
                                                	}
                                                	}
                                        }else{
                                               	set=0;
                                                }


                                        }
                                 if(set==1)status=true;
                                        else{
                                                status=false;
                                        }

                        }
                        if(dir==Direction.HORIZONTAL){
                        //checking for bottom
                                int set=1;
                                if(set==1){
                                        if((p.y_coord+size_ship[shipId])<10){
                                        for(int i=0;i<size_ship[shipId];i++)//checking right side
                                                {
                                                if(board_array[p.x_coord][p.y_coord+i]!=(Id[shipId])){
                                                        set=0;
                                                        break;
                                                        }
                                                }
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)                                                                                				{
                                                        board_array[p.x_coord][p.y_coord+i]='.';
                                                }
                                                }
                                        }else{
                                                set=0;
                                                }
                                        }
				display(false);
                                if(set!=1){
                                        set=1;
                                         if((p.y_coord-size_ship[shipId])>-1){
                                        for(int i=0;i<size_ship[shipId];i++)//checking left side
                                                {
                                                if(board_array[p.x_coord][p.y_coord-i]!=(Id[shipId])){
                                                        set=0;
                                                        break;
                                                        }
                                                }
					display(false);
                                        if(set==1){
                                                for(int i=0;i<size_ship[shipId];i++)
                                                {
                                                        board_array[p.x_coord][p.y_coord-i]='.';
                                                }
                                                }
                                        }else{
                                                set=0;
                                                }

                                         }
                                 if(set==1)status=true;
                                        else{
                                                status=false;
                                        }

                                }
                        if(dir!=Direction.HORIZONTAL && dir!=Direction.VERTICAL){
                                status=false;
                                }
                        }

                        return status;
                }
               void clear(){
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					board_array[i][j]='.';
					}
					}
			}
		boolean allShipsDestroyed(){
			boolean status=true;
			outerloop:
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					if(board_array[i][j]!='.' && board_array[i][j]!='o' && board_array[i][j]!='X'){
						status=false;
						break outerloop;
						}
					}
				}
			return status;
			}				
	}	

	
public class test{
	public static void main(String[] args){
/*Use this for testing of Board class with all functions
		Board b =new Board(10,10);
		Point p= new Point(8,8);
		Point p2 = new Point(2,2);
		boolean check=b.placeShip(p,2,Direction.HORIZONTAL);
		if(check)System.out.println("Placed Ship was : 2");
		else{
			System.out.println("Ship 2 was not placed");
			}
		check =b.placeShip(p2,1,Direction.VERTICAL);
		
                if(check)System.out.println("Placed Ship was : 1");
		else{
			System.out.println("Ship 1 was not placed");
			}
		b.display(false);
		b.display(true);
		b.display(false);
		b.unplaceShip(p,2,Direction.HORIZONTAL);
		b.display(false);
		b.unplaceShip(p2,1,Direction.VERTICAL);
		b.display(false);
		System.out.println("All ships destroyed:"+b.allShipsDestroyed());
		b.clear();
		System.out.println("All ships destroyed:"+b.allShipsDestroyed());
		
	*/
		}
		
		}











				
		
		



