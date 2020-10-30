/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

import org.oclc.circill.toolkit.dummy.ConfigurableServiceHandler
import org.oclc.circill.toolkit.service.base.ServiceInitiationData
import org.oclc.circill.toolkit.service.base.ServiceResponseData
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData
import org.oclc.circill.toolkit.service.ncip.Problem
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError

class NCIPUnsupportedService implements ConfigurableServiceHandler {
    boolean canHandle(ServiceInitiationData initiationData) {
        return initiationData instanceof NCIPInitiationData
    }
    ServiceResponseData handle(ServiceInitiationData initiationData) {
        ProblemResponseData response = new ProblemResponseData()
        Problem problem = new Problem()
        problem.setProblemType(Version1GeneralProcessingError.UNSUPPORTED_SERVICE)
        response.setProblems(Collections.singletonList(problem))
        return response
    }
}
