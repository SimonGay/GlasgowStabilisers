/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class TH extends Token
{
    public TH()
    {
        super.setText("H");
    }

    public TH(int line, int pos)
    {
        super.setText("H");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TH(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTH(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TH text.");
    }
}
