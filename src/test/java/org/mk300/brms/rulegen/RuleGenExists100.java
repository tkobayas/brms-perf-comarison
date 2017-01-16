package org.mk300.brms.rulegen;

public class RuleGenExists100 {

    static final int RULE_NUM = 100;

    public static void main(String[] args) throws Exception {

        StringBuilder builder = new StringBuilder();

        builder.append("package org.mk300.brms.perf.exists\n\n");
        builder.append("import org.mk300.brms.perf.facts.*;\n");
        builder.append("import org.mk300.brms.perf.functions.*;\n\n");
        builder.append("global MyFunction result;\n\n");

        for (int i = 0; i < RULE_NUM; i++) {
            
            int suffixX = (i / 10) + 1;
            
            int suffix1 = (i % 10) + 1;
            int suffix2 = ((i + 1) % 10) + 1;
            int suffix3 = ((i + 2) % 10) + 1;
            int suffix4 = ((i + 3) % 10) + 1;
            int suffix5 = ((i + 4) % 10) + 1;

            builder.append("rule \"Rule" + i + "\"\n");
            builder.append("when\n");
            builder.append("    $f1 : MyFact1()\n");
            builder.append("    $f2 : MyFact2(id == $f1.id, value1 == \"hoge1\", value2 == $f1.value2, value3 == $f1.value3, value4 == $f1.value4, value5 == $f1.value5)\n");
            builder.append("    $f3 : MyFact3(id == $f1.id, value1 == \"hoge" + suffixX + "\", value2 == $f1.value2, value3 == $f1.value3, value4 == $f1.value4, value5 == $f1.value5)\n");
            builder.append("    $f4 : MyFact4(id == $f1.id, value1 == \"hoge" + suffix1 + "\", value2 == $f1.value2, value3 == $f1.value3, value4 == $f1.value4, value5 == $f1.value5)\n");
            builder.append("    exists MyFact5(id == $f1.id && value1 == $f4.value1)\n");
            builder.append("then\n");
//            builder.append("System.out.println(kcontext.getRule());\n");
            builder.append("    result.getRuleResult().add($f1.getValue1() + \",\" + $f2.getValue1());\n");
            builder.append("end\n");
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

}
