/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.analysis;

import java.util.*;
import equivalence.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPProcess().apply(this);
        outStart(node);
    }

    public void inATermProcess(ATermProcess node)
    {
        defaultIn(node);
    }

    public void outATermProcess(ATermProcess node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATermProcess(ATermProcess node)
    {
        inATermProcess(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outATermProcess(node);
    }

    public void inAParallelProcess(AParallelProcess node)
    {
        defaultIn(node);
    }

    public void outAParallelProcess(AParallelProcess node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParallelProcess(AParallelProcess node)
    {
        inAParallelProcess(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getParallel() != null)
        {
            node.getParallel().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outAParallelProcess(node);
    }

    public void inANilTerm(ANilTerm node)
    {
        defaultIn(node);
    }

    public void outANilTerm(ANilTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANilTerm(ANilTerm node)
    {
        inANilTerm(node);
        if(node.getNil() != null)
        {
            node.getNil().apply(this);
        }
        outANilTerm(node);
    }

    public void inASendTerm(ASendTerm node)
    {
        defaultIn(node);
    }

    public void outASendTerm(ASendTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASendTerm(ASendTerm node)
    {
        inASendTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getChannel() != null)
        {
            node.getChannel().apply(this);
        }
        if(node.getOn() != null)
        {
            node.getOn().apply(this);
        }
        if(node.getData() != null)
        {
            node.getData().apply(this);
        }
        if(node.getSend() != null)
        {
            node.getSend().apply(this);
        }
        outASendTerm(node);
    }

    public void inAReceiveTerm(AReceiveTerm node)
    {
        defaultIn(node);
    }

    public void outAReceiveTerm(AReceiveTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAReceiveTerm(AReceiveTerm node)
    {
        inAReceiveTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getChannel() != null)
        {
            node.getChannel().apply(this);
        }
        if(node.getOn() != null)
        {
            node.getOn().apply(this);
        }
        if(node.getData() != null)
        {
            node.getData().apply(this);
        }
        if(node.getReceive() != null)
        {
            node.getReceive().apply(this);
        }
        outAReceiveTerm(node);
    }

    public void inAMeasureTerm(AMeasureTerm node)
    {
        defaultIn(node);
    }

    public void outAMeasureTerm(AMeasureTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMeasureTerm(AMeasureTerm node)
    {
        inAMeasureTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getSource() != null)
        {
            node.getSource().apply(this);
        }
        if(node.getMeasure() != null)
        {
            node.getMeasure().apply(this);
        }
        if(node.getAssign() != null)
        {
            node.getAssign().apply(this);
        }
        if(node.getTarget() != null)
        {
            node.getTarget().apply(this);
        }
        outAMeasureTerm(node);
    }

    public void inAXTerm(AXTerm node)
    {
        defaultIn(node);
    }

    public void outAXTerm(AXTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAXTerm(AXTerm node)
    {
        inAXTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getX() != null)
        {
            node.getX().apply(this);
        }
        outAXTerm(node);
    }

    public void inAYTerm(AYTerm node)
    {
        defaultIn(node);
    }

    public void outAYTerm(AYTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAYTerm(AYTerm node)
    {
        inAYTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getY() != null)
        {
            node.getY().apply(this);
        }
        outAYTerm(node);
    }

    public void inAZTerm(AZTerm node)
    {
        defaultIn(node);
    }

    public void outAZTerm(AZTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAZTerm(AZTerm node)
    {
        inAZTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getZ() != null)
        {
            node.getZ().apply(this);
        }
        outAZTerm(node);
    }

    public void inAHTerm(AHTerm node)
    {
        defaultIn(node);
    }

    public void outAHTerm(AHTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAHTerm(AHTerm node)
    {
        inAHTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getH() != null)
        {
            node.getH().apply(this);
        }
        outAHTerm(node);
    }

    public void inACnotTerm(ACnotTerm node)
    {
        defaultIn(node);
    }

    public void outACnotTerm(ACnotTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACnotTerm(ACnotTerm node)
    {
        inACnotTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getSnd() != null)
        {
            node.getSnd().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getFst() != null)
        {
            node.getFst().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getCnot() != null)
        {
            node.getCnot().apply(this);
        }
        outACnotTerm(node);
    }

    public void inAIfxTerm(AIfxTerm node)
    {
        defaultIn(node);
    }

    public void outAIfxTerm(AIfxTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfxTerm(AIfxTerm node)
    {
        inAIfxTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getTarget() != null)
        {
            node.getTarget().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getX() != null)
        {
            node.getX().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getCond() != null)
        {
            node.getCond().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfxTerm(node);
    }

    public void inAIfyTerm(AIfyTerm node)
    {
        defaultIn(node);
    }

    public void outAIfyTerm(AIfyTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfyTerm(AIfyTerm node)
    {
        inAIfyTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getTarget() != null)
        {
            node.getTarget().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getY() != null)
        {
            node.getY().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getCond() != null)
        {
            node.getCond().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfyTerm(node);
    }

    public void inAIfzTerm(AIfzTerm node)
    {
        defaultIn(node);
    }

    public void outAIfzTerm(AIfzTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfzTerm(AIfzTerm node)
    {
        inAIfzTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getTarget() != null)
        {
            node.getTarget().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        if(node.getZ() != null)
        {
            node.getZ().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getCond() != null)
        {
            node.getCond().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfzTerm(node);
    }

    public void inANewTerm(ANewTerm node)
    {
        defaultIn(node);
    }

    public void outANewTerm(ANewTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewTerm(ANewTerm node)
    {
        inANewTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getNewqubit() != null)
        {
            node.getNewqubit().apply(this);
        }
        outANewTerm(node);
    }

    public void inAInputTerm(AInputTerm node)
    {
        defaultIn(node);
    }

    public void outAInputTerm(AInputTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInputTerm(AInputTerm node)
    {
        inAInputTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getIdlist() != null)
        {
            node.getIdlist().apply(this);
        }
        if(node.getInput() != null)
        {
            node.getInput().apply(this);
        }
        outAInputTerm(node);
    }

    public void inAOutputTerm(AOutputTerm node)
    {
        defaultIn(node);
    }

    public void outAOutputTerm(AOutputTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOutputTerm(AOutputTerm node)
    {
        inAOutputTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getIdlist() != null)
        {
            node.getIdlist().apply(this);
        }
        if(node.getOutput() != null)
        {
            node.getOutput().apply(this);
        }
        outAOutputTerm(node);
    }

    public void inAPrintTerm(APrintTerm node)
    {
        defaultIn(node);
    }

    public void outAPrintTerm(APrintTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrintTerm(APrintTerm node)
    {
        inAPrintTerm(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        if(node.getSep() != null)
        {
            node.getSep().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPrint() != null)
        {
            node.getPrint().apply(this);
        }
        outAPrintTerm(node);
    }

    public void inAParensTerm(AParensTerm node)
    {
        defaultIn(node);
    }

    public void outAParensTerm(AParensTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParensTerm(AParensTerm node)
    {
        inAParensTerm(node);
        if(node.getRparen() != null)
        {
            node.getRparen().apply(this);
        }
        if(node.getProcess() != null)
        {
            node.getProcess().apply(this);
        }
        if(node.getLparen() != null)
        {
            node.getLparen().apply(this);
        }
        outAParensTerm(node);
    }

    public void inAIdIdlist(AIdIdlist node)
    {
        defaultIn(node);
    }

    public void outAIdIdlist(AIdIdlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdIdlist(AIdIdlist node)
    {
        inAIdIdlist(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdIdlist(node);
    }

    public void inAIdconsIdlist(AIdconsIdlist node)
    {
        defaultIn(node);
    }

    public void outAIdconsIdlist(AIdconsIdlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdconsIdlist(AIdconsIdlist node)
    {
        inAIdconsIdlist(node);
        if(node.getIdlist() != null)
        {
            node.getIdlist().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdconsIdlist(node);
    }

    public void inADotSep(ADotSep node)
    {
        defaultIn(node);
    }

    public void outADotSep(ADotSep node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADotSep(ADotSep node)
    {
        inADotSep(node);
        if(node.getDot() != null)
        {
            node.getDot().apply(this);
        }
        outADotSep(node);
    }

    public void inASemiSep(ASemiSep node)
    {
        defaultIn(node);
    }

    public void outASemiSep(ASemiSep node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASemiSep(ASemiSep node)
    {
        inASemiSep(node);
        if(node.getSemi() != null)
        {
            node.getSemi().apply(this);
        }
        outASemiSep(node);
    }
}