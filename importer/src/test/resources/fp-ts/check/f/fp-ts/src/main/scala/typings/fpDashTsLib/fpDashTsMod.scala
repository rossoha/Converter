package typings
package fpDashTsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts", JSImport.Namespace)
@js.native
object fpDashTsMod extends js.Object {
  @JSName("either")
  @js.native
  object eitherNs extends js.Object {
    val URI: /* Either */ java.lang.String = js.native
  }
  
  @JSName("task")
  @js.native
  object taskNs extends js.Object {
    def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): fpDashTsLib.libEitherMod.Either[L, A] = js.native
  }
  
}
