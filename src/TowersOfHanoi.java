/**
 * This implementation is derived from the Tower of Hanoi Algorithm
 * Source Code available at
 * http://www.softwareandfinance.com/Java/TowerOfHanoi_Algorithm.html
 */

import java.lang.*;
import java.util.*;

@SuppressWarnings("unchecked")
class TowersOfHanoi {
    private static int numberOfMoves = 0;
    private static void Solve2DiscsTowersOfHanoi(Stack source, Stack temp, Stack dest ) {
        temp.push ( source.pop() );
        numberOfMoves++;
        PrintStacks();
        dest.push ( source.pop() );
        numberOfMoves++;
        PrintStacks();
        dest.push ( temp.pop() );
        numberOfMoves++;
        PrintStacks();
    }
    private static  int solveTowersOfHanoi ( int numberOfDiscs, Stack source, Stack temp, Stack dest ) {
        if ( numberOfDiscs <= 4 ) {
            if ( ( numberOfDiscs % 2 ) == 0 ) {
                Solve2DiscsTowersOfHanoi( source, temp, dest );
                numberOfDiscs = numberOfDiscs - 1;
                if ( numberOfDiscs == 1 ) {
                    return 1;
                }
                temp.push ( source.pop() );
                numberOfMoves++;
                PrintStacks();
                Solve2DiscsTowersOfHanoi( dest, source, temp );
                dest.push ( source.pop() );
                numberOfMoves++;
                PrintStacks();
                solveTowersOfHanoi ( numberOfDiscs, temp, source, dest );
            } else {
                if ( numberOfDiscs == 1 ) {
                    return -1;
                }
                Solve2DiscsTowersOfHanoi( source, dest, temp );
                numberOfDiscs = numberOfDiscs - 1;
                dest.push ( source.pop() );
                numberOfMoves++;
                PrintStacks();
                Solve2DiscsTowersOfHanoi( temp, source, dest );
            }
            return 1;
        } else if ( numberOfDiscs >= 5 ) {
            solveTowersOfHanoi ( numberOfDiscs - 2, source, temp, dest );
            temp.push ( source.pop() );
            numberOfMoves++;
            PrintStacks();
            solveTowersOfHanoi ( numberOfDiscs - 2, dest, source, temp );
            dest.push ( source.pop() );
            numberOfMoves++;
            PrintStacks();
            solveTowersOfHanoi ( numberOfDiscs - 1, temp, source, dest );
        }
        return 1;
    }
    private static Stack A = new Stack();
    private static Stack B = new Stack();
    private static Stack C = new Stack();
    private static void PrintStacks() {
        if ( countA != A.size() ||
                countB != B.size() ||
                countC != C.size() ) {
            int diffA = A.size() - countA;
            int diffB = B.size() - countB;
            int diffC = C.size() - countC;
            if ( diffA == 1 ) {
                if ( diffB == -1 ) {
                    System.out.print ( "Move Disc " + A.peek() + " From B To A" );
                } else {
                    System.out.print ( "Move Disc " + A.peek() + " From C To A" );
                }
            } else if ( diffB == 1 ) {
                if ( diffA == -1 ) {
                    System.out.print ( "Move Disc " + B.peek() + " From A To B" );
                } else {
                    System.out.print ( "Move Disc " + B.peek() + " From C To B" );
                }
            } else {
                if ( diffA == -1 ) {
                    System.out.print ( "Move Disc " + C.peek() + " From A To C" );
                } else {
                    System.out.print ( "Move Disc " + C.peek() + " From B To C" );
                }
            }
            countA = A.size();
            countB = B.size();
            countC = C.size();
            System.out.println();
        }
        PrintStack ( A );
        System.out.print ( " , " );
        PrintStack ( B );
        System.out.print ( " , " );
        PrintStack ( C );
        System.out.print ( " , " );
    }
    private static int countA = 0;
    private static int countB = 0;
    private static int countC = 0;
    static private void PrintStack ( Stack s ) {
        System.out.print ( s.toString() );
    }
    public static void main ( String[] args ) {
        try {
            int maxStartingHeight;
            String startingHeight = args[0];
            numberOfMoves = 0;
            maxStartingHeight = Integer.parseInt ( startingHeight );
            if ( maxStartingHeight <= 1 || maxStartingHeight >= 10 ) {
                System.out.println ( "Enter between 2 - 9" );
                return;
            }
            for ( int i = maxStartingHeight; i >= 1; i--) {
                A.push ( i );
            }
            countA = A.size();
            countB = B.size();
            countC = C.size();
            PrintStacks();
            solveTowersOfHanoi ( maxStartingHeight, A, B, C );
            System.out.println ( "Total Moves = " + numberOfMoves);
            while ( C.size() > 0 ) {
                C.pop();
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}