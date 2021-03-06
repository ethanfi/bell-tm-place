package cn.edu.bnuz.bell.place

import cn.edu.bnuz.bell.security.SecurityService
import org.springframework.http.HttpStatus

class BookingCheckInterceptor {
    SecurityService securityService

    boolean before() {
        if (params.checkerId != securityService.userId) {
            render(status: HttpStatus.FORBIDDEN)
            return false
        } else {
            return true
        }
    }

    boolean after() { true }

    void afterView() {}
}
