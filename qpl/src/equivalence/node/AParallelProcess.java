/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class AParallelProcess extends PProcess
{
    private PTerm _left_;
    private TParallel _parallel_;
    private PTerm _right_;

    public AParallelProcess()
    {
        // Constructor
    }

    public AParallelProcess(
        @SuppressWarnings("hiding") PTerm _left_,
        @SuppressWarnings("hiding") TParallel _parallel_,
        @SuppressWarnings("hiding") PTerm _right_)
    {
        // Constructor
        setLeft(_left_);

        setParallel(_parallel_);

        setRight(_right_);

    }

    @Override
    public Object clone()
    {
        return new AParallelProcess(
            cloneNode(this._left_),
            cloneNode(this._parallel_),
            cloneNode(this._right_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParallelProcess(this);
    }

    public PTerm getLeft()
    {
        return this._left_;
    }

    public void setLeft(PTerm node)
    {
        if(this._left_ != null)
        {
            this._left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._left_ = node;
    }

    public TParallel getParallel()
    {
        return this._parallel_;
    }

    public void setParallel(TParallel node)
    {
        if(this._parallel_ != null)
        {
            this._parallel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parallel_ = node;
    }

    public PTerm getRight()
    {
        return this._right_;
    }

    public void setRight(PTerm node)
    {
        if(this._right_ != null)
        {
            this._right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._right_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._left_)
            + toString(this._parallel_)
            + toString(this._right_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._left_ == child)
        {
            this._left_ = null;
            return;
        }

        if(this._parallel_ == child)
        {
            this._parallel_ = null;
            return;
        }

        if(this._right_ == child)
        {
            this._right_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._left_ == oldChild)
        {
            setLeft((PTerm) newChild);
            return;
        }

        if(this._parallel_ == oldChild)
        {
            setParallel((TParallel) newChild);
            return;
        }

        if(this._right_ == oldChild)
        {
            setRight((PTerm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}