package typingsJapgolly.stardustUiReactComponentEventListener

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typesMod {
  type EventHandler[T /* <: typingsJapgolly.stardustUiReactComponentEventListener.typesMod.EventTypes */] = js.Function1[
    /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any, 
    scala.Unit
  ]
  type EventTypes = java.lang.String
  type TargetRef = japgolly.scalajs.react.raw.React.RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ]
}
