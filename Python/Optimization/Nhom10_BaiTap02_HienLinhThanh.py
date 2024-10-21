# Thông tin nhóm 10:
# Bùi Thu Hiền, 20000476, K65A1 Toán Học.
# Nguyễn Khánh Linh, 20000488, K65A1 Toán Học.
# Bùi Tiến Thành, 20000509, K65A1 Toán Học. 

# Import: 
import string
import random

# Bài 1: Tọa độ trên bàn cờ

# 1.1. Viết một hàm trả về tọa độ của 64 ô trên bàn cờ (theo góc nhìn của trắng).
# Make Chess Board:
def Chess_Board():
    C_B = []
    # Take list of character:
    alphabet = list(string.ascii_lowercase)
    Column = alphabet[0:8]
    # Merge character from column and number from row and append them to make chess board: 
    for row_location in range(1,9):
        Row = [] # Or Row = [column_location+str(row_location) for column_location in Board_Column]
        for column_location in Column: 
            Row.append(column_location+str(row_location)) 
        C_B.append(Row)
    # Reverse so the result is from White view
    C_B.reverse() #Or CB = list(reversed(CB))
        
    return C_B

print(Chess_Board())
# Mistake: CB = CB.reverse() is return None Because list.reverse() uses in place modification, what this means is that the method does not return a new object and instead modifies the already existing one. So you can't assign it's value to itself. 

# 1.2.Viết một hàm trả về tọa độ của 32 ô trắng của bàn cờ.
def White_Chess_Board():  
    # Re-use Chess Board and Make empty-list for contain White box.
    CB = Chess_Board()
    W_C_B = []
    column_value = 0 #Initial value to track White box
    # Take white box postion from CB every column in every row
    for row in range(0,int(len(CB[0]))): # Or W_C_B =[[CB[row][column] for column in range(column_value,int(len(CB)),2)] for row in range(0,int(len(CB[0])))]
        Row = [] # Or Row = [CB[row][column] for column in range(column_value,int(len(CB)),2)]
        for column in range(column_value,int(len(CB)),2): # Between every two white box have a black box. So step of column be 2.
            Row.append(CB[row][column])
        column_value = (column_value+1)%2 # Change of Initial column value when change row. 
        W_C_B.append(Row)

    return W_C_B

print(White_Chess_Board())

# 1.3. Viết một hàm in ra terminal tọa độ của tất cả các ô trên bàn cờ, sắp xếp theo góc nhìn của bên cầm quân trắng. Thông tin in ra màn hình có dạng
def Chess_box():
    CB = Chess_Board()
    # Print every column from every row:
    for row in range(0,int(len(CB[0]))):
        for column in range(0,int(len(CB))):
            print(CB[row][column],end=" ")
        print("\n")

Chess_box()

# Hàm in ra tọa độ 32 ô trắng.
def White_chess_box():
    WCB = White_Chess_Board()
    #Print every column from every row
    for row in range(0,int(len(WCB))):
        for column in range(0,int(len(WCB[0]))):
            print(WCB[row][column],end=" ")
        print("\n")

White_chess_box()

# Bài 2: Lấy phần tử ngẫu nhiên
# Viết một hàm nhận vào một list và trả về một phần tử ngẫu nhiên trong danh sách đó.
def Random_List(List):
    return List[random.randint(0,int(len(List))-1)]

print(Random_List(["foo","bar",1,2]))

# Bài 3: Lọc phần tử
# Viết một hàm nhận vào hai list A, list B và trả về list C chứa các phần tử thuộc A nhưng không thuộc B.

# C1:
def Complement(List_A,List_B):
    list_C = []
    # For every a element in First List compare if it in the other List or not.
    for a in List_A:
        if a not in List_B:
            list_C.append(a)
    
    return list_C

print(Complement([1,2,3,4,"A","B"],[1,2,3,"A"]))

# C2:
def Complement(List_A,List_B):
    List_C = []

    for a in List_A:
        if a in List_B:
            List_C.append(a)

    for loc in range(0,len(List_C)): # Use independent here .remove() (or .pop()) method because when is removes an item from List_A in loop is skip an index in List_A so make errors in the result.
        List_A.remove(List_C[loc])

    return List_A

print(Complement([1,2,3,4,"A","B"],[1,2,3,"A"]))

# Bài 4: Nước đi của quân hậu:
def Queen_Move(Queen_loc):
    # Reuse Chess Board function and make a empty-list to contain Queen move 
    CB = Chess_Board()
    QM = []
    # Chess move have move with "letter" + "number" for "column" + "row".
    RCB = list(reversed(range(1,9,1)))
    CCB = list(string.ascii_lowercase)

    Row_Queen = RCB.index(int(Queen_loc[1]))
    Column_Queen = CCB.index(Queen_loc[0])
    # Queen Move in Row:
    RQM = CB[Row_Queen]
    QM.extend(RQM)
    #Queen Move in Column:
    CQM = []

    for row in range(0,int(len(CB))):
        CQM.append(CB[row][Column_Queen])

    QM.extend(CQM)
    #Main-Diagonal Queen Move:
    ODQM = []
    
    while True:
        Row_Queen += 1
        Column_Queen -= 1 
        if Row_Queen <= 7 and Column_Queen >= 0: 
            ODQM.append(CB[Row_Queen][Column_Queen])
        else:
            Row_Queen = RCB.index(int(Queen_loc[1]))
            Column_Queen = CCB.index(Queen_loc[0])
            while True:
                Row_Queen -= 1
                Column_Queen += 1
                if Row_Queen >= 0 and Column_Queen <= 7:
                    ODQM.append(CB[Row_Queen][Column_Queen])
                else:
                    break
            break
    
    QM.extend(ODQM)
    #Off- Diagonal Queen Move:
    MDQM = []

    Row_Queen = RCB.index(int(Queen_loc[1]))
    Column_Queen = CCB.index(Queen_loc[0])
    
    while True:
        Row_Queen += 1
        Column_Queen += 1 
        if Row_Queen <= 7 and Column_Queen <= 7: 
            MDQM.append(CB[Row_Queen][Column_Queen])
        else:
            Row_Queen = RCB.index(int(Queen_loc[1]))
            Column_Queen = CCB.index(Queen_loc[0])
            while True:
                Row_Queen -= 1
                Column_Queen -= 1
                if Row_Queen >= 0 and Column_Queen >= 0:
                    MDQM.append(CB[Row_Queen][Column_Queen])
                else:
                    break
            break
    
    QM.extend(MDQM) 
    # Remove Queen Location from Row and Column Queen Move (RQM - CQM).
    QM.remove(Queen_loc)
    QM.remove(Queen_loc)

    return QM

print(Queen_Move("d4"))
