.MODEL SMALL
.STACK 100H
.DATA
X DB 80 DUP
N DB 0

.CODE      
MOV AX, @DATA
MOV DS, AX

MAIN PROC
    MOV SI, 0
    MOV AH, 1
    INT 21H
    MOV N, AL
    MOV AL, 0
    
    FOR: INT 21H
        CMP AL, N
        JG EXIT
        
        INC SI
        JMP FOR
        
    EXIT: DEC SI

    SORT:
    MOV BX, SI
    
    EXTER:
        CMP SI, 0
        JL END
        MOV DI, SI
        INER: CMP DI, 0
            JL EXEND
            MOV CL, X[DI]
            CMP X[SI], CL
            JL MOVE
            INEND:
            DEC DI
            JMP INER
        EXEND: DEC SI
        JMP EXTER
        
    MOVE: XCHG CL, X[SI]
        MOV X[DI], CL
        JMP INEND
    
    END: MOV SI, 0
    MOV AH, 2
    MOV DL, 0AH
    INT 21H
    MOV DL, 0DH
    INT 21H
     
    LOOPING:
        CMP BX, SI
        JL FINISH
        MOV DL, X[SI] 
        INT 21H
        INC SI
        JMP LOOPING
    FINISH: MOV AH, 4CH
        INT 21H
MAIN ENDP
END MAIN