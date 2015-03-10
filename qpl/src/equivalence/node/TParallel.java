/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class TParallel extends Token
{
    public TParallel()
    {
        super.setText("|");
    }

    public TParallel(int line, int pos)
    {
        super.setText("|");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TParallel(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTParallel(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TParallel text.");
    }
}
