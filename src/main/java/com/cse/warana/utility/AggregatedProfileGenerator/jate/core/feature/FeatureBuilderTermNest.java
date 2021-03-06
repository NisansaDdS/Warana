package com.cse.warana.utility.AggregatedProfileGenerator.jate.core.feature;

import com.cse.warana.utility.AggregatedProfileGenerator.jate.JATEException;
import com.cse.warana.utility.AggregatedProfileGenerator.jate.core.feature.indexer.GlobalIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A specific type of feature builder that builds an instance of FeatureTermNest from a GlobalIndex.
 * Counting of term nested frequency is based on <b>canonical forms</b>.
 * <p/>
 * <br>Also credits to <b>pmclachlan@gmail.com</b> for revision for performance tweak </br>
 *
 * @author <a href="mailto:z.zhang@dcs.shef.ac.uk">Ziqi Zhang</a>
 */


public class FeatureBuilderTermNest extends AbstractFeatureBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(FeatureBuilderTermNest.class);

    /**
     * Default constructor
     */
    public FeatureBuilderTermNest() {
        super(null, null, null);
    }

    /**
     * Build an instance of FeatureTermNest from an instance of GlobalIndexMem
     *
     * @param index
     * @return
     * @throws com.cse.warana.utility.AggregatedProfileGenerator.jate.JATEException
     */
    public FeatureTermNest build(GlobalIndex index) throws JATEException {
        FeatureTermNest _feature = new FeatureTermNest(index);
        if (index.getTermsCanonical().size() == 0 || index.getDocuments().size() == 0) throw new
                JATEException("No resource indexed!");

        LOG.info("About to build FeatureTermNest...");
        int counter = 0;
        for (String np : index.getTermsCanonical()) {
            /*for (String anp : index.getTermsCanonical()) {
                   if (anp.length() <= np.length()) continue;
                   if (anp.indexOf(" " + np) != -1 || anp.indexOf(np + " ") != -1) //e.g., np=male, anp=the male
                       _feature.termNestIn(np, anp);
               }
               counter++;*/

            //  Expensive string operations pulled out for performance of the inner loop
            final String spacePrefixed = " " + np;
            final String spaceSuffixed = np + " ";

            for (String anp : index.getTermsCanonical()) {
                if (anp.length() <= np.length()) continue;
                if (anp.indexOf(spacePrefixed) != -1 || anp.indexOf(spaceSuffixed) != -1) //e.g., np=male, anp=the male
                    _feature.termNestIn(np, anp);
            }
            counter++;


            if (counter % 500 == 0) LOG.info("Batch done" + counter + " end: " + np);
        }
        return _feature;
    }
}
