package com.olvind.tso
package scalajs

final case class QualifiedName(parts: List[Name]) {
  def +(name: Name) =
    QualifiedName(parts :+ name)

  def ++(other: QualifiedName): QualifiedName =
    QualifiedName(parts ++ other.parts)

  def startsWith(other: QualifiedName): Boolean =
    parts.startsWith(other.parts)
}

object QualifiedName {
  val java_lang:     QualifiedName = QualifiedName(Name.java :: Name.lang :: Nil)
  val scala:         QualifiedName = QualifiedName(Name.scala :: Nil)
  val scala_scalajs: QualifiedName = scala + Name.scalajs
  val scala_js:      QualifiedName = scala_scalajs + Name.js
  val scala_js_ann:  QualifiedName = scala_js + Name("annotation")
  val Runtime:       QualifiedName = QualifiedName(List(Name.OutputPkg, Name("runtime")))

  val String:           QualifiedName = java_lang + Name.String
  val JObject:          QualifiedName = java_lang + Name.Object
  val JArray:           QualifiedName = java_lang + Name.Array
  val ScalaAny:         QualifiedName = scala + Name.Any
  val Double:           QualifiedName = scala + Name.Double
  val Int:              QualifiedName = scala + Name.Int
  val Long:             QualifiedName = scala + Name.Long
  val Boolean:          QualifiedName = scala + Name.Boolean
  val Unit:             QualifiedName = scala + Name.Unit
  val Null:             QualifiedName = scala + Name.Null
  val Nothing:          QualifiedName = scala + Name.Nothing
  val Any:              QualifiedName = scala_js + Name.Any
  val Object:           QualifiedName = scala_js + Name.Object
  val Array:            QualifiedName = scala_js + Name.Array
  val `|`             : QualifiedName = scala_js + Name("|")
  val Function:         QualifiedName = scala_js + Name.Function
  val Symbol:           QualifiedName = scala_js + Name.Symbol
  val UndefOr:          QualifiedName = scala_js + Name.UndefOr
  val Dynamic:          QualifiedName = scala_js + Name.Dynamic
  val NumberDictionary: QualifiedName = Runtime + Name("NumberDictionary")
  val StringDictionary: QualifiedName = Runtime + Name("StringDictionary")
  val TopLevel:         QualifiedName = Runtime + Name("TopLevel")
  val UNION:            QualifiedName = QualifiedName(Name("<union>") :: Nil)
  val INTERSECTION:     QualifiedName = QualifiedName(Name("<intersection>") :: Nil)
  val SINGLETON:        QualifiedName = QualifiedName(Name("<typeof>") :: Nil)
  val LITERAL:          QualifiedName = QualifiedName(Name("<literal>") :: Nil)
  val THIS_TYPE:        QualifiedName = QualifiedName(Name("<this>") :: Nil)
  val IGNORED:          QualifiedName = QualifiedName(Name("<ignored>") :: Nil)
  val REPEATED:         QualifiedName = QualifiedName(Name("*") :: Nil)

  def Instantiable(arity:  Int): QualifiedName = Runtime + Name(s"Instantiable$arity")
  def FunctionArity(arity: Int): QualifiedName = scala_js + Name.FunctionArity(arity)
  def Tuple(arity:         Int): QualifiedName =
    arity match {
      case 0 | 1 => Array
      case n     => scala_js + Name("Tuple" + n.toString)
    }

  implicit object QualifiedNameSuffix extends ToSuffix[QualifiedName] {
    override def to(t: QualifiedName): Suffix = ToSuffix(t.parts.last)
  }
}