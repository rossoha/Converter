package org.scalablytyped.converter
package internal
package scalajs

object Optional {
  val nulls: Set[TypeRef] = Set(TypeRef.Null, TypeRef.undefined)

  def unapply(tpe: TypeRef): Option[TypeRef] =
    tpe match {
      case TypeRef.Union(types) =>
        types partition nulls match {
          case (IArray.Empty, _) => None
          case (_, remaining)    => Some(TypeRef.Union(remaining, sort = false))
        }
      case _ => None
    }
}
