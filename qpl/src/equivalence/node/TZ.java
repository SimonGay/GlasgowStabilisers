/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class TZ extends Token
{
    public TZ()
    {
        super.setText("Z");
    }

    public TZ(int line, int pos)
    {
        super.setText("Z");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TZ(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTZ(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TZ text.");
    }
}
