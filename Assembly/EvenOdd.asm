INCLUDE 'EMU8086.INC'
.MODEL SMALL
.STACK 100H
.DATA
N DB 0

.CODE      
MOV AX, @DATA
MOV DS, AX

MAIN PROC
    MOV AH, 1
    INT 21H
    MOV N, AL
    SUB N, 30H
    
    MOV AH, 2
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H
        
    MOV BX, 2
    MOV AX, 0
    MOV AL, N
    MOV DX, 0
    
    DIV BX
    
    CMP DX, 0
    JE EVEN
    PRINTN
    PRINT 'ODD '
    JMP END
        
    EVEN:
        PRINTN
        PRINT 'EVEN'
    END:
        MOV AH, 4CH
        INT 21H
MAIN ENDP
END MAIN