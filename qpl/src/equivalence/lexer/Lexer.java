/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.lexer;

import java.io.*;
import equivalence.node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private IPushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") final PushbackReader in)
    {
        this.in = new IPushbackReader() {

            private PushbackReader pushbackReader = in;
            
            @Override
            public void unread(int c) throws IOException {
                pushbackReader.unread(c);
            }
            
            @Override
            public int read() throws IOException {
                return pushbackReader.read();
            }
        };
    }
 
    public Lexer(@SuppressWarnings("hiding") IPushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        // int middle = (low + high) / 2;
                        int middle = (low + high) >>> 1;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            @SuppressWarnings("hiding") Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            @SuppressWarnings("hiding") Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            @SuppressWarnings("hiding") Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            @SuppressWarnings("hiding") Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            @SuppressWarnings("hiding") Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            @SuppressWarnings("hiding") Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            @SuppressWarnings("hiding") Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            @SuppressWarnings("hiding") Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            @SuppressWarnings("hiding") Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            @SuppressWarnings("hiding") Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            @SuppressWarnings("hiding") Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            @SuppressWarnings("hiding") Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            @SuppressWarnings("hiding") Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            @SuppressWarnings("hiding") Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            @SuppressWarnings("hiding") Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            @SuppressWarnings("hiding") Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            @SuppressWarnings("hiding") Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            @SuppressWarnings("hiding") Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            @SuppressWarnings("hiding") Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            @SuppressWarnings("hiding") Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            @SuppressWarnings("hiding") Token token = new26(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            @SuppressWarnings("hiding") Token token = new27(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            @SuppressWarnings("hiding") Token token = new28(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            @SuppressWarnings("hiding") Token token = new29(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            new InvalidToken(this.text.substring(0, 1), start_line + 1, start_pos + 1),
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TParallel(line, pos); }
    Token new1(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDot(line, pos); }
    Token new2(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNil(line, pos); }
    Token new3(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSemi(line, pos); }
    Token new4(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TComma(line, pos); }
    Token new5(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBang(line, pos); }
    Token new6(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSend(line, pos); }
    Token new7(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TQuery(line, pos); }
    Token new8(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TReceive(line, pos); }
    Token new9(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TOn(line, pos); }
    Token new10(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TX(line, pos); }
    Token new11(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TY(line, pos); }
    Token new12(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TZ(line, pos); }
    Token new13(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TH(line, pos); }
    Token new14(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TCnot(line, pos); }
    Token new15(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMeasure(line, pos); }
    Token new16(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNewqubit(line, pos); }
    Token new17(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIf(line, pos); }
    Token new18(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TThen(line, pos); }
    Token new19(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TElse(line, pos); }
    Token new20(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TInput(line, pos); }
    Token new21(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TOutput(line, pos); }
    Token new22(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPrint(line, pos); }
    Token new23(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAssign(line, pos); }
    Token new24(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLparen(line, pos); }
    Token new25(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRparen(line, pos); }
    Token new26(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIntlit(text, line, pos); }
    Token new27(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBlank(text, line, pos); }
    Token new28(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TComment(text, line, pos); }
    Token new29(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TId(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {33, 33, 5}, {40, 40, 6}, {41, 41, 7}, {44, 44, 8}, {46, 46, 9}, {47, 47, 10}, {48, 57, 11}, {58, 58, 12}, {59, 59, 13}, {63, 63, 14}, {65, 66, 15}, {67, 67, 16}, {68, 71, 15}, {72, 72, 17}, {73, 87, 15}, {88, 88, 18}, {89, 89, 19}, {90, 90, 20}, {97, 100, 15}, {101, 101, 21}, {102, 104, 15}, {105, 105, 22}, {106, 108, 15}, {109, 109, 23}, {110, 110, 24}, {111, 111, 25}, {112, 112, 26}, {113, 113, 15}, {114, 114, 27}, {115, 115, 28}, {116, 116, 29}, {117, 122, 15}, {124, 124, 30}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {},
            {},
            {},
            {},
            {},
            {{47, 47, 31}, },
            {{48, 57, 32}, },
            {{61, 61, 33}, },
            {},
            {},
            {{65, 90, 34}, {97, 122, 34}, },
            {{65, 77, 34}, {78, 78, 35}, {79, 90, 34}, {97, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 90, 34}, {97, 107, 34}, {108, 108, 36}, {109, 122, 34}, },
            {{65, 90, 34}, {97, 101, 34}, {102, 102, 37}, {103, 109, 34}, {110, 110, 38}, {111, 122, 34}, },
            {{65, 90, 34}, {97, 100, 34}, {101, 101, 39}, {102, 122, 34}, },
            {{65, 100, -25}, {101, 101, 40}, {102, 104, 34}, {105, 105, 41}, {106, 122, 34}, },
            {{65, 90, 34}, {97, 109, 34}, {110, 110, 42}, {111, 116, 34}, {117, 117, 43}, {118, 122, 34}, },
            {{65, 90, 34}, {97, 113, 34}, {114, 114, 44}, {115, 122, 34}, },
            {{65, 100, -25}, {101, 101, 45}, {102, 122, 34}, },
            {{65, 100, -25}, {101, 101, 46}, {102, 122, 34}, },
            {{65, 90, 34}, {97, 103, 34}, {104, 104, 47}, {105, 122, 34}, },
            {},
            {{9, 9, 48}, {10, 10, 49}, {13, 13, 50}, {32, 127, 48}, },
            {{48, 57, 32}, },
            {},
            {{65, 122, -17}, },
            {{65, 78, 34}, {79, 79, 51}, {80, 90, 34}, {97, 122, 34}, },
            {{65, 90, 34}, {97, 114, 34}, {115, 115, 52}, {116, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 90, 34}, {97, 111, 34}, {112, 112, 53}, {113, 122, 34}, },
            {{65, 90, 34}, {97, 97, 54}, {98, 122, 34}, },
            {{65, 90, 34}, {97, 118, 34}, {119, 119, 55}, {120, 122, 34}, },
            {{65, 107, -23}, {108, 108, 56}, {109, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 90, 34}, {97, 115, 34}, {116, 116, 57}, {117, 122, 34}, },
            {{65, 90, 34}, {97, 104, 34}, {105, 105, 58}, {106, 122, 34}, },
            {{65, 90, 34}, {97, 98, 34}, {99, 99, 59}, {100, 122, 34}, },
            {{65, 109, -27}, {110, 110, 60}, {111, 122, 34}, },
            {{65, 100, -25}, {101, 101, 61}, {102, 122, 34}, },
            {{9, 127, -33}, },
            {},
            {},
            {{65, 83, 34}, {84, 84, 62}, {85, 90, 34}, {97, 122, 34}, },
            {{65, 100, -25}, {101, 101, 63}, {102, 122, 34}, },
            {{65, 90, 34}, {97, 116, 34}, {117, 117, 64}, {118, 122, 34}, },
            {{65, 114, -38}, {115, 115, 65}, {116, 122, 34}, },
            {{65, 90, 34}, {97, 112, 34}, {113, 113, 66}, {114, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 111, -40}, {112, 112, 67}, {113, 122, 34}, },
            {{65, 109, -27}, {110, 110, 68}, {111, 122, 34}, },
            {{65, 100, -25}, {101, 101, 69}, {102, 122, 34}, },
            {{65, 90, 34}, {97, 99, 34}, {100, 100, 70}, {101, 122, 34}, },
            {{65, 109, -27}, {110, 110, 71}, {111, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 115, -45}, {116, 116, 72}, {117, 122, 34}, },
            {{65, 116, -55}, {117, 117, 73}, {118, 122, 34}, },
            {{65, 116, -55}, {117, 117, 74}, {118, 122, 34}, },
            {{65, 116, -55}, {117, 117, 75}, {118, 122, 34}, },
            {{65, 115, -45}, {116, 116, 76}, {117, 122, 34}, },
            {{65, 104, -46}, {105, 105, 77}, {106, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
            {{65, 113, -28}, {114, 114, 78}, {115, 122, 34}, },
            {{65, 90, 34}, {97, 97, 34}, {98, 98, 79}, {99, 122, 34}, },
            {{65, 115, -45}, {116, 116, 80}, {117, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 90, 34}, {97, 117, 34}, {118, 118, 81}, {119, 122, 34}, },
            {{65, 100, -25}, {101, 101, 82}, {102, 122, 34}, },
            {{65, 104, -46}, {105, 105, 83}, {106, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 100, -25}, {101, 101, 84}, {102, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 115, -45}, {116, 116, 85}, {117, 122, 34}, },
            {{65, 122, -17}, },
            {{65, 122, -17}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {27, 27, 27, 27, 27, 5, 24, 25, 4, 1, -1, 26, -1, 3, 7, 29, 29, 13, 10, 11, 12, 29, 29, 29, 29, 29, 29, 29, 29, 29, 0, -1, 26, 23, 29, 29, 29, 17, 29, 29, 29, 29, 9, 29, 29, 29, 29, 29, -1, 28, 28, 29, 29, 29, 29, 29, 2, 29, 29, 29, 29, 29, 14, 19, 29, 29, 29, 29, 29, 29, 6, 18, 20, 29, 29, 29, 22, 29, 29, 29, 21, 29, 15, 29, 8, 16, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}
