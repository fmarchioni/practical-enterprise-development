package org.javaee7.jsf.flow;

import java.io.Serializable;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.flow.Flow;
import jakarta.faces.flow.builder.FlowBuilder;
import jakarta.faces.flow.builder.FlowBuilderParameter;
import jakarta.faces.flow.builder.FlowDefinition;

public class Flow1 implements Serializable {

    private static final long serialVersionUID = -7623501087369765218L;

//    @Produces @FlowDefinition
//    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
//        String flowId = "flow1";
//        flowBuilder.id("", flowId);
//        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
//
//        return flowBuilder.getFlow();
//    }
}
