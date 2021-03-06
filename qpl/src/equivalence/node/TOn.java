/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class TOn extends Token
{
    public TOn()
    {
        super.setText("on");
    }

    public TOn(int line, int pos)
    {
        super.setText("on");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TOn(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTOn(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TOn text.");
    }
}
